<template>
  <div  style="width: 100%">
    <el-row>
      <el-col :offset="2" :span="18">

        <el-table
          :data="pageData"
          stripe
          style="width: 100%;margin-top: 50px;">
          <el-table-column
            type="index"
            width="55">
          </el-table-column>
          <el-table-column
            prop="operation"
            label="操作"
            width="180">
          </el-table-column>
          <el-table-column
            prop="userName"
            label="操作人"
            width="200">
          </el-table-column>
          <el-table-column
            prop="ip"
            label="IP"
            width="200">
          </el-table-column>
          <el-table-column
            prop="method"
            label="方法名"
            width="460">
          </el-table-column>
          <el-table-column
            prop="params"
            label="参数"
            width="140">
          </el-table-column>
          <el-table-column
            prop="operateTime"
            label="操作时间"
            width="200">
          </el-table-column>
        </el-table>

        <el-pagination
          style="margin-bottom: 50px"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="current_page"
          :page-sizes="[10, 20]"
          :page-size="page_size"
          layout="total, sizes, prev, pager, next, jumper"
          :total="tableData.length">
        </el-pagination>

      </el-col>
    </el-row>
  </div>
</template>

<script>
  import ajaxUtils from '../http/ajaxUtils'
  import store from '../store/index'
  import {getSessionUser,setSessionUser} from '../storage/index'
  export default {
    computed: {
      pageData() {
        let start = (this.current_page - 1) * this.page_size
        return [...this.tableData].splice(start,this.page_size)
      }
    },
    data() {
      return{
        page_size:10,
        current_page:1,
        tableData:[]
      }
    },
    methods: {
      handleSizeChange(size) {
        this.page_size = size;
      },
      handleCurrentChange(pageIndex) {
        this.current_page = pageIndex
      },
      initData() {
        ajaxUtils.send("/api/syslog/list",null ,result=> {
          if (result.code==200) {
            this.tableData = result.result
          } else if ( result.code == 414) {
            store.commit("SHOW_LOGIN",true)
            return
          }
        })
      }
    },
    mounted() {
      this.initData()
    }
  }
</script>
<style>


</style>
