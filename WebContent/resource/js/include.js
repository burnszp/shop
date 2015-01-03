// 所有模块都通过 define 来定义
define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require('jquery');
//	var jQuery = $;
	require('jquery-ui');
	require('juqery-ui_touch');
	require('bootstrap');
	require('bootstrap-select');
	require('jquery-tagsinput');
	require('jquery-placeholder');
	require('typeahead');
	require('application');
});