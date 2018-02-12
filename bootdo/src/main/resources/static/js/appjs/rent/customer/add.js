$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});

function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/rent/customer/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			number : {
				required : true,
				remote : {
					url : "/rent/customer/exit", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						number : function() {
							return $("#number").val();
						} 
					}
				}
			},
			customerName : {
				required : true,
			},
			customerStatus : {
				required : function(){
					return $("#houseStatus").attr("checked");
				}
			},
			agree : "required"
		},
		messages : {
			number : {
				required : icon + "请输入业务号",
				remote : icon + "该业务号已经存在"
			},
			customerName : {
				required : icon + "请输入客户名称",
			}
		}
	})
}

