// 以下为官方示例
$().ready(function() {
	validateRule();
	// $("#signupForm").validate();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$("#roleIds").val(getCheckedRoles());
	$.ajax({
		cache : true,
		type : "POST",
		url : "/rent/house/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg(data.msg);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.msg(data.msg);
			}

		}
	});

}
function getCheckedRoles() {
	var adIds = "";
	$("input:checkbox[name=role]:checked").each(function(i) {
		if (0 == i) {
			adIds = $(this).val();
		} else {
			adIds += ("," + $(this).val());
		}
	});
	return adIds;
}
function setCheckedRoles() {
	var roleIds = $("#roleIds").val();
	var adIds = "";
	$("input:checkbox[name=role]:checked").each(function(i) {
		if (0 == i) {
			adIds = $(this).val();
		} else {
			adIds += ("," + $(this).val());
		}
	});
	return adIds;
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			houseNumber : {
				required : true,
			},
			address : {
				required : true,
			},
			space : {
				required : true,
			},
			area : {
				required : true,
			},
			houseType : {
				required : function(){
					return $("#houseType").attr("checked");
				}
			},
			houseStatus : {
				required : function(){
					return $("#houseStatus").attr("checked");
				}
			},
			agree : "required"
		},
		messages : {
			houseNumber : {
				required : icon + "请输入房屋编号",
			},
			address : {
				required : icon + "请输入房屋地址",
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
