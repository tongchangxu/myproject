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
		url : "/rent/house/save",
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
			address : {
				required : true,
				remote : {
					url : "/rent/house/exit", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						name : function() {
							return $("#address").val();
						} 
					}
				}
			},
			space : {
				required : true,
			},
			area : {
				required : true,
			},
			houseStatus : {
				required : function(){
					return $("#houseStatus").attr("checked");
				}
			},
			agree : "required"
		},
		messages : {
			address : {
				required : icon + "请输入房屋地址",
				remote : icon + "该房屋地址已经存在"
			},
			space : {
				required : icon + "请输入面积",
			},
			area : {
				required : icon + "请输入归属区域",
			}
		}
	})
}

