package pres.haimi.csc.task.api.controller;


import pres.haimi.csc.task.api.interceptor.ApiFilter;
import pres.haimi.csc.task.common.Auth;
import pres.haimi.csc.task.model.apiwrapper.APIListResult;
import pres.haimi.csc.task.model.apiwrapper.APIResult;
import pres.haimi.csc.task.model.apiwrapper.APIResultCode;
import pres.haimi.csc.task.model.apiwrapper.ListPackage;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

/**
 * 基础的控制器，里面放公用方法
 */
public class BaseController {

    protected int getAuth() {
        HttpServletRequest request= ApiFilter.requestThreadLocal.get();
        if (request == null || request.getAttribute(Auth.AUTH) == null) {
            return -1;
        }
        return (int)request.getAttribute(Auth.AUTH);
    }

    protected APIResult handleNoAuth(Integer auth) {
        if (Objects.equals(auth, Auth.BLACK)) {
            return asUnAuthError("权限被限制，请联系管理员！");
        }
        if (Objects.equals(auth,Auth.NO_AUTH)) {
            return asUnLogin("请先登陆");
        }
        return asUnAuthError("没有权限！");
    }

    protected <T> APIResult<T> asSuccess(T t) {
		return new APIResult<>(APIResultCode.SUCCESS.getValue(), null, t);
	}
    protected <T> APIResult<T> asSuccess(T t,String message) {
        return new APIResult<>(APIResultCode.SUCCESS.getValue(), message, t);
    }
	protected APIResult<String> asError(String message) {
		return new APIResult<>(APIResultCode.ERROR.getValue(), message, null);
	}

    protected APIResult<String> asError(String message, Throwable e) {
        return new APIResult<>(APIResultCode.ERROR.getValue(), message + "[" + e.getMessage() + "]", null);
    }

    protected APIResult<String> asNotFound(String message) {
        return new APIResult<>(APIResultCode.NOTFOUND.getValue(), message, null);
    }

    protected APIResult<String> asBadRequest(String message) {
        return new APIResult<>(APIResultCode.BADREQUEST.getValue(), message, null);
    }

    protected APIResult<String> asUnLogin(String message) {
        return new APIResult<>(APIResultCode.UNLOGIN.getValue(), message, null);
    }

	protected APIResult<String> asUnAuthError(String message) {
		return new APIResult<>(APIResultCode.UNAUTHORITY.getValue(), message, null);
	}

	protected <T> APIListResult<T> asSuccess(List<T> t, int count) {
		ListPackage<T> list = new ListPackage<>();
		list.setList(t);
		list.setCount(count);
		return new APIListResult<>(APIResultCode.SUCCESS.getValue(), "SUCCESS", list);
	}

    public String getBodyStr(HttpServletRequest request) {
        InputStream is = null;
        StringBuilder sb = new StringBuilder();
        try {
            is = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
