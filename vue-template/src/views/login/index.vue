<template>
  <div class="login-page">
    <canvas id="login-background" />

    <div class="login-container" @click.stop>
      <div class="title">springboot-vue后台管理系统</div>

      <component :is="component" />
    </div>
  </div>
</template>

<script>
import LoginForm from './components/LoginForm';

export default {
  name: 'Login',

  components: { LoginForm },

  data() {
    return {
      animationInstance: null,
    };
  },

  computed: {
    component() {
      const formType = this.$route.path.substring(1);
      return `${[...formType].join('')}-form`;
    },
  },

  methods: {
    clearAnimation() {
      if (this.animationInstance) {
        this.animationInstance.stop();
        this.animationInstance = null;
      }
    },
  },

  beforeDestroy() {
    this.clearAnimation();
    this.$message.closeAll();
  },
};
</script>

<style lang="scss" src="./components/style.scss"></style>
