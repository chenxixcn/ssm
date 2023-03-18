<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="/css/amazeui.min.css" />
		<link rel="stylesheet" href="/css/admin.css" />
	</head>

	<body>
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">请假管理</strong><small></small></div>
			</div>

			<hr>

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default btnAdd"><span class="am-icon-plus"></span>申请请假</button>
							<button type="button" style="margin-left: 20px;" class="am-btn am-btn-default btnFindNotes" onclick="selectNoteByEid(${emp.eid})"><span class="am-icon-archive"></span> 请假记录 </button>
							<button type="button" style="margin-left: 20px;" class="am-btn am-btn-default btnFindNoCheck" onclick="selectStatus(nstatus=0)"><span class="am-icon-archive"></span> 待审批</button>
							<button type="button" style="margin-left: 20px;" class="am-btn am-btn-default btnFindCheck" onclick="selectStatus(nstatus=1)"><span class="am-icon-archive"></span> 已审批 </button>
						</div>
					</div>
				</div>
			</div>
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check"><input type="checkbox" id="chkAll"></th>
									<th class="table-id" style="width:100px;">ID</th>
									<th class="table-title">申请人</th>
									<th class="table-title">请假标题</th>
									<th class="table-type">事由说明</th>
									<th class="table-dname">请假开始日期</th>
									<th class="table-role">请假结束日期</th>
									<th class="table-role">主管审批状态</th>
									<th class="table-set">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${info.list}" var="note">
								<tr>
									<td><input type="checkbox" name="chk"></td>
									<td>${note.nid}</td>
									<td>${note.employee.realname}</td>
									<td>${note.title}</td>
									<td>${note.context}</td>
									<td class="am-hide-sm-only"><span class="am-badge  am-badge-danger "></span><fmt:formatDate value="${note.startdate}" pattern="yyyy年MM月dd天"/></td>

									<td><fmt:formatDate value="${note.enddate}" pattern="yyyy年MM月dd天"/></td>
									<td>${note.nstatus==0?"未审批":note.nstatus==1?"同意":note.nstatus==2?"打回":"不同意"}</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
                                                <c:if test="${nstatus==null and note.nstatus==2}">
                                                    <button type="button" id="depart_24" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit" onclick="selectByNid(${note.nid})"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                                </c:if>
                                                <c:if test="${nstatus==0}">
                                                <button type="button" id="depart_24" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit" onclick="updateStatus(${note.nid},1)"><span class="am-icon-pencil-square-o"></span> 同意</button>
												<button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="updateStatus(${note.nid},2)"><span class="am-icon-trash-o"></span> 打回</button>
												<button type="button" id="depart_24" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit" onclick="updateStatus(${note.nid},3)"><span class="am-icon-pencil-square-o"></span> 不同意</button>
                                                </c:if>
											</div>
										</div>
									</td>
								</tr>

							</c:forEach>

							</tbody>
						</table>
                        <div class="am-cf" style="margin-right: 30px;">
                            共 ${info.total} 条记录
                            <div class="am-fr">
                                <ul class="am-pagination">
                                    <c:if test="${info.pageNum!=1}">
                                        <li class="am-active">
                                            <a href="/employee/selectEmployeeByStatus.do?estatus=${estatus}&page=${info.pageNum-1}"> << </a>
                                        </li>
                                    </c:if>
                                    <c:forEach begin="1" end="${info.pages}" step="1" var="i">
                                        <li>
                                            <a href="/employee/selectEmployeeByStatus.do?estatus=${estatus}&page=${i}">${i}</a>
                                        </li>
                                    </c:forEach>

                                    <c:if test="${info.pageNum!=info.pages}">
                                        <li class="am-active">
                                            <a href="/employee/selectEmployeeByStatus.do?estatus=${estatus}&page=${info.pageNum+1}"> >> </a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
						<hr>
					</form>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="/js/jquery-1.11.3.min.js" ></script>
		<script type="text/javascript" src="/myplugs/js/plugs.js" ></script>
		<script>
            //点击审核和未审核
			function selectStatus(nstatus){
				window.location.href="/note/selectStatus.do?nstatus="+nstatus
			}
            //查询记录
			function selectNoteByEid(eid){
				window.location.href="/note/selectNoteByEid.do?eid="+eid
			}
            function updateStatus(nid,nstatus){
                window.location.href="/note/updateStatus.do?nid="+nid+"&nstatus="+nstatus
            }
            function selectByNid(nid){
                window.location.href="/note/selectByNid.do?nid="+nid
            }
			$(function() {			
				$(".btnAdd").click(function() {
					$.jq_Panel({
						title: "申请请假",
						iframeWidth: 600,
						iframeHeight: 560,
						url: "/addLeave.jsp"
					});
				});
			});
		</script>
	</body>

</html>