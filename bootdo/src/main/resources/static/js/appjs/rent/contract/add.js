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
		url : "/rent/contract/save",
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
			contractNumber : {
				required : true,
			},
			contractName : {
				required : true,
			},
			operator : {
				required : true,
			},
			number : {
				required : true,
			},
			startTime : {
				required : true,
			},
			stopTime : {
				required : true,
			},
			rent : {
				required : true,
			},
			leadTime : {
				required : function(){
					return $("#leadTime").attr("checked");
				}
			},
			invoiceType : {
				required : true,
			},
			growthRate : {
				required : true,
			},
			growthTime : {
				required : true,
			},
			rentDetail : {
				required : true,
			},
			deposit : {
				required : true,
			},
			contractStatus : {
				required : function(){
					return $("#contractStatus").attr("checked");
				}
			},
			company : {
				required : true,
			},
			agree : "required"
		},
		messages : {
			contractNumber : {
				required : icon + "合同编号不能为空",
			},
			contractName : {
				required : icon + "合同名称不能为空",
			},
			operator : {
				required : icon + "合同名称不能为空",
			},
			number : {
				required : icon + "业务号不能为空",
			},
			startTime : {
				required : icon + "合同起始时间不能为空",
			},
			stopTime : {
				required : icon + "合同终止时间不能为空",
			},
			rent : {
				required : icon + "租金不能为空",
			},
			invoiceType : {
				required : icon + "发票类型不能为空",
			},
			growthRate : {
				required : icon + "递增周期不能为空",
			},
			growthTime : {
				required : icon + "递增周期不能为空",
			},
			rentDetail : {
				required : icon + "租金明细不能为空",
			},
			deposit : {
				required : icon + "定金不能为空",
			},
			company : {
				required : icon + "关联公司不能为空",
			}
		}
	})
}


