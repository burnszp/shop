define(function(require, exports, module) {
	var Print = require('print');
	var print = new Print();
	 
	$('#btnPrint').click(function(){ 
		print.printDiv(document.getElementById("divPrint"));
		
	});
});