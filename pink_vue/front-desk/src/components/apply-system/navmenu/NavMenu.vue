
<!-- 展示页logo的信息 -->
<template>
  <div>
    <el-menu :default-active="activeIndex" mode="horizontal" @select="handleSelect" background-color="#ffffff" text-color="#000000" active-text-color="#ffd04b" style="border: 0">
      <el-menu-item disabled>

        
      <router-link :to="{path:'/index/apply_home'}">
        <img src="../../../assets/img/logo/logo_04.png" alt="LOGO" class="logo">
       </router-link>
      
      </el-menu-item>
      <slot></slot>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "NavMenu",
  data() {
    return {
      activeIndex: '1'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
@import "../../../assets/css/apply-system/components/navmenu.css";
</style>
