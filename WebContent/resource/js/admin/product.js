define(function(require, exports, module) {
	var Page = require('page');
	var Tooltip = require('tooltip');
	var tooltip = new Tooltip();
	new Page(pageSize, pageNumber, pageCount);
	var selectedIds = "";
	$('a[flag="view"').click(
			function() {
				var checkboxs = $('input[type="checkbox"]:checked');
				if (checkboxs.length == 0) {
					tooltip.show('请至少选择一条商品进行查看');
					return

				}
				if (checkboxs.length > 1) {
					tooltip.show('请选择一条商品进行查看');
					return;
				} else {
					window.location.href = ctx + "/admin/userform?id="
							+ $(checkboxs[0]).val();
				}

			});
	$('a[flag="del"').click(
			function() {
				selectedIds = "";
				var checkboxs = $('input[type="checkbox"]:checked');
				if (checkboxs.length == 0) {
					tooltip.show('请选择要下架的商品');
					return

				}
				checkboxs.each(function(i, val) {
					selectedIds += $(val).val() + ",";
				});
				$('#myModal').modal();
				$('#modalOk').unbind().click(
						function() {
							window.location.href = ctx
									+ "/admin/product?method=del&ids="
									+ selectedIds;
						});
			});

	$('a[flag="upload"').click(
			function() {
				selectedIds = "";
				var checkboxs = $('input[type="checkbox"]:checked');
				if (checkboxs.length == 0) {
					tooltip.show('请选择要上架的商品');
					return

				}
				checkboxs.each(function(i, val) {
					selectedIds += $(val).val() + ",";
				});
				$('#myModal').modal();
				$('#modalOk').unbind().click(
						function() {
							window.location.href = ctx
									+ "/admin/product?method=upload&ids="
									+ selectedIds;
						});
			});
});