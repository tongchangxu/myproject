var prefix = "/rent/contract"
$(function() {
	load();
});
function load() {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/handleList", // 服务器数据的加载地址
				// showRefresh : true,
				// showToggle : true,
				// showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : true, // 设置为true会有隔行变色效果
				dataType : "json", // 服务器返回的数据类型
				pagination : true, // 设置为true会在底部显示分页条
				// queryParamsType : "limit",
				// //设置为limit则会发送符合RESTFull格式的参数
				singleSelect : true, // 设置为true将禁止多选
				// contentType : "application/x-www-form-urlencoded",
				// //发送到服务器的数据编码类型
				pageSize : 10, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				// search : true, // 是否显示搜索框
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
				// "server"
				queryParams : function(params) {
					return {
						// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						address : $('#address').val(),
						houseNumber : $('#houseNumber').val(),
						number : $('#number').val(),
						contractNumber : $('#contractNumber').val()
					};
				},
				// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
				// queryParamsType = 'limit' ,返回参数必须包含
				// limit, offset, search, sort, order 否则, 需要包含:
				// pageSize, pageNumber, searchText, sortName,
				// sortOrder.
				// 返回false将会终止请求
				columns : [
					{
						field : 'contractId', // 列字段名
						title : '合同序号' // 列标题
					},
					{
						title : '正式合同编号',
						field : 'contractNumber',
						align : 'center',
						formatter : function(value, row, index) {
							var e = '<a href="#"  onclick="edit(\''
									+ row.contractNumber
									+ '\')">'+row.contractNumber+'</a> ';
							return e;
						}
					},
					{
						field : 'operator',
						title : '经办人'
					},
					{
						field : 'number',
						title : '业务号'
					},
					{
						field : 'contractName',
						title : '合同名称'
					},
					{
						field : 'company',
						title : '关联公司'
					},
					{
						field : 'rent',
						title : '租金'
					},
					{
						field : 'startTime',
						title : '起始时间'
					},
					{
						field : 'stopTime',
						title : '到期日期'
					},
					{
						field : 'leadTime',
						title : '缴费周期'
					},
					{
						field : 'invoiceType',
						title : '发票类型'
					},
					{
						field : 'growthRate',
						title : '年递增率'
					},
					{
						field : 'growthTime',
						title : '递增周期'
					},
					{
						field : 'rentDetail',
						title : '租金明细'
					},
					{
						field : 'deposit',
						title : '定金'
					},
					{
						field : 'area',
						title : '归属区域'
					},
					{
						field : 'createTime',
						title : '创建日期'
					},
					{
						field : 'contractStatus',
						title : '合同状态',
						align : 'center',
						formatter : function(value, row, index) {
							if (value == '新增') {
								return '<span class="label label-success">新增</span>';
							} else if (value == '在用') {
								return '<span class="label label-primary">在用</span>';
							} else if (value == '退租') {
								return '<span class="label label-warning">退租</span>';
							} else if (value == '合同到期') {
								return '<span class="label label-default">合同到期</span>';
							} else if (value == '终止协议') {
								return '<span class="label label-danger">终止协议</span>';
							}
						}
					} ,
					{
						field : 'statusDescription',
						title : '合同状态说明'
						
					},
					{
						field : 'handle',
						title : '操作'
					},
					{
						field : 'handleTime',
						title : '操作日期'
					}]
			});
}

function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

