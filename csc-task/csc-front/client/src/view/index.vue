<template>
  <content-module name="dashboard">
    <header-nav></header-nav>
    <car-picture></car-picture>
    <!--<lab-part></lab-part>-->
  </content-module>
</template>
<script>
  import HeaderNav from '../components/Header.nav.vue'
  import CarPicture from '../components/carousel.vue'
  /*import LabPart from './laboratory/LabPart.vue'*/
  export default {
    components: {
      HeaderNav,
      CarPicture,
      /*  LabPart*/
    }
  }
</script>
