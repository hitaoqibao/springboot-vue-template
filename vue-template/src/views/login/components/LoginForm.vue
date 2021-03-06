<template>
  <el-form ref="form" :model="form" :rules="rules" label-position="left">
    <el-form-item prop="username">
      <span class="svg-container">
        <svg-icon icon-class="user" />
      </span>

      <el-input
        ref="username"
        v-model="form.username"
        :maxlength="20"
        name="username"
        placeholder="请输入用户名"
        type="text"
      />
    </el-form-item>

    <el-form-item prop="password">
      <el-tooltip
        v-model="capsTooltip"
        :tabindex="-1"
        content="大写锁定已打开"
        manual
        placement="left"
      >
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
      </el-tooltip>

      <el-input
        ref="password"
        v-model="form.password"
        :key="passwordType"
        :type="passwordType"
        :maxlength="20"
        name="password"
        placeholder="请输入密码"
        @keyup.enter.native="login"
      />

      <span @click="showPwd" class="show-pwd">
        <svg-icon
          :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'"
        />
      </span>
    </el-form-item>

    <el-button
      :loading="loading"
      class="submit-btn"
      type="primary"
      @click="login"
      >{{ loading ? '登 录 中...' : '登 录' }}</el-button
    >

    <div class="flex" style="margin-top: 20px">
      <p class="other-ways">
        其他方式登录
        <svg-icon
          v-for="i in otherWays"
          :key="i"
          :icon-class="i"
          @click="thirdPartyLogin(i)"
        />
      </p>

      <el-button style="float:right" type="text" @click="register"
        >注册账户</el-button
      >
    </div>
  </el-form>
</template>

<script>
import { isEmpty } from '@/utils';

export default {
  name: 'LoginForm',

  data() {
    return {
      loading: false,
      form: {
        username: '',
        password: '',
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'change' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'change' },
          { min: 6, max: 32, message: '请输入6-32位的密码', trigger: 'change' },
        ],
      },
      passwordType: 'password',
      capsTooltip: false,
      otherWays: ['qq', 'wechat', 'weibo'],
    };
  },

  methods: {
    showPwd() {
      this.passwordType = this.passwordType === 'password' ? '' : 'password';
      this.$nextTick(() => this.$refs.password.focus());
    },

    login() {
      if (this.loading) return;
      this.$refs.form.validate((valid) => {
        if (!valid) return;
        this.loading = true;
        this.$store
          .dispatch('user/login', this.form)
          .then(() => {
            this.$router.push({
              path: this.redirect || '/',
              query: this.otherQuery,
            });
            this.loading = false;
          })
          .catch(() => {
            this.loading = false;
          });
      });
    },

    register() {
      !this.loading && this.$router.push('/register');
    },

    thirdPartyLogin(channel) {
      this.$message.info('假装可以第三方登录');
    },

    capsLockTip({ keyCode }) {
      if (keyCode === 20) this.capsTooltip = !this.capsTooltip;
    },

    addCapsLockEvent() {
      document.addEventListener('keyup', this.capsLockTip);
    },

    removeEvent() {
      document.removeEventListener('keyup', this.addCapsLockEvent);
    },
  },

  mounted() {
    this.addCapsLockEvent();
    if (isEmpty(this.form.username)) this.$refs.username.focus();
    else this.$refs.password.focus();
  },

  beforeDestroy() {
    this.removeEvent();
  },
};
</script>
