<template>
  <div>
    <el-drawer
      :visible="value"
      :with-header="false"
      append-to-body
      size="260px"
      @close="$emit('input', false)"
    >
      <div class="drawer-container">
        <div>
          <h3 class="drawer-title">系统布局配置</h3>

          <div class="drawer-item">
            <span>主题色</span>
            <theme-picker
              style="float: right;height: 26px;margin: -3px 8px 0 0;"
              @change="themeChange"
            />
          </div>

          <div class="drawer-item">
            <span>开启标签</span>
            <el-switch v-model="tagsView" class="drawer-switch" />
          </div>

          <div class="drawer-item">
            <span>固定页眉</span>
            <el-switch v-model="fixedHeader" class="drawer-switch" />
          </div>

          <div class="drawer-item">
            <span>显示logo</span>
            <el-switch v-model="sidebarLogo" class="drawer-switch" />
          </div>
        </div>
      </div>
    </el-drawer>
  </div>
</template>

<script>
import ThemePicker from '@/components/ThemePicker';
export default {
  components: { ThemePicker },
  name: 'SettingDrawer',
  props: {
    value: Boolean,
  },
  computed: {
    fixedHeader: {
      get() {
        return this.$store.state.settings.fixedHeader;
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'fixedHeader',
          value: val,
        });
      },
    },
    tagsView: {
      get() {
        return this.$store.state.settings.tagsView;
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'tagsView',
          value: val,
        });
      },
    },
    sidebarLogo: {
      get() {
        return this.$store.state.settings.sidebarLogo;
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'sidebarLogo',
          value: val,
        });
      },
    },
  },
  methods: {
    themeChange(val) {
      this.$store.dispatch('settings/changeSetting', {
        key: 'theme',
        value: val,
      });
    },
  },
};
</script>

<style lang="scss" scoped>
.drawer-container {
  padding: 24px;
  font-size: 14px;
  line-height: 1.5;
  word-wrap: break-word;

  .drawer-item {
    color: rgba(0, 0, 0, 0.65);
    font-size: 14px;
    padding: 12px 0;
  }

  .drawer-switch {
    float: right;
  }
}
</style>
