
define(function(require, exports, module) {
	function Print(){
		
	}
	Print.prototype.printDiv=function(obj) {
		// 打开一个新窗口newWindow
		var newWindow = window.open("打印窗口", "_blank");
		// 要打印的div的内容
		var docStr = obj.innerHTML;
		// 打印内容写入newWindow文档
		newWindow.document.write(docStr);
		// 关闭文档
		newWindow.document.close();
		// 调用打印机
		newWindow.print();
		// 关闭newWindow页面由于有些浏览器在newWindow关闭后，会出现打印预览失败的情况，所以暂时不关闭该文档
		// newWindow.close();

	};
	
	module.exports = Print;

});