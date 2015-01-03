define(function(require, exports, module) {
	 $('#btnAddcar').click(function(){
		 var amount = $('#txtAmount').val();
		 var productId= $('#productId').val();
		// alert(amount+'---'+productId);
		 alert(ctx+'/shoppingcar?method=add&productId='+productId+'&amount='+amount);
		window.reload(ctx+'/shoppingcar?method=add&productId='+productId+'&amount='+amount);
	 });
	 
	 
});