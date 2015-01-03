// 所有模块都通过 define 来定义
define(function(require, exports, module) {
 	function Tooltip(container) {
 		if(!container){
 			container="tooltip";
 		}
		this.container = $('#' + container);
	}
 	

	Tooltip.prototype.show = function(text) {
		this.container.html(text);
		this.container.css('width',(text.length*20)+'px');
		this.container.show();
	};
	Tooltip.prototype.hide = function() {
		this.container.hide();
	};
	
	Tooltip.prototype.tooltip=function(text){
		this.show(text);
		var me = this;
		setTimeout(function(){
			me.hide();
			
		},3000);
	}
	
	Tooltip.prototype.alert = function(text) {
		alert(text);
	};
	module.exports = Tooltip;
});