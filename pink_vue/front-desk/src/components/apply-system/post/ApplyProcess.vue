<!-- 对于应聘者申请状态的显示的一个组件 -->
<template>
   <div class="post-item" @click="postClick">
    <el-row>
      <el-col :span="12">
        <div class="header-content">
          <li class="job-name" id="name">{{apply.recruitment.r_name}}</li>
          <li class="job-info">
            <span class="r_salary">{{apply.recruitment.r_salary}}</span>
            <span class="r_experience">{{apply.recruitment.r_experience}}</span>
            <span class="r_education">{{apply.recruitment.r_education}}</span>
            <span class="r_address">{{apply.recruitment.r_address}}</span>
          </li>
        </div>
      </el-col>
       <el-col :span="8">
        <div class="header-content">
        </div>
      </el-col>
      <el-col :span="4">
        <div class="header-content">
          <div class="company-logo">
            <span v-if="apply.is_delete==0">暂未未审批</span>
            <span v-if="apply.is_delete==1" style="color: red;">恭喜通过</span>
            <span v-if="apply.is_delete==2" style="color: gray;">遗憾未通过</span>
          </div>
        </div>
      </el-col>
    </el-row>
 <!--    <el-row class="bottom-content">
      <el-col :span="20">
        <div class="footer-content">
          <el-tag v-for="item in (post.r_tag).split(',')" :key="item" type="info" size="mini" style="margin-left: 12px">
            {{item}}
          </el-tag>
        </div>
      </el-col>
      <el-col :span="4">
        <div class="footer-content">
          <span class="welfare">
            {{post.welfare}}
          </span>
        </div>
      </el-col>
    </el-row> -->
</div>
</template>
 

<script>
  export default {
    name: "ApplyProcess",
    props: {
      apply: {type: Object}
    },
    data() {
      return {
        showName: ''

      }
    },
    methods: {
  

    },
    mounted() {
      
    }
  }
</script>

<style scoped>
@import "../../../assets/css/apply-system/components/applyprocess.css";
</style>
