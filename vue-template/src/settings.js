module.exports = {
  //标题
  title: '后台管理系统',

  /**
   * @type {boolean} true | false
   * @description 设置是否显示
   */
  showSettings: false,

  /**
   * @type {boolean} true | false
   * @description 标签是否显示
   */
  tagsView: true,

  /**
   * @type {boolean} true | false
   * @description 抬头是否固定
   */
  fixedHeader: true,

  /**
   * @type {boolean} true | false
   * @description 标题栏是否显示
   */
  sidebarLogo: true,

  /**
   * @type {string | array} 'production' | ['production', 'development']
   * @description Need show err logs component.
   * The default is only used in the production env
   * If you want to also use it in dev, you can pass ['production', 'development']
   */
  errorLog: 'production'
}