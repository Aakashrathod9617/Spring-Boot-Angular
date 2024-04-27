
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
 
   table {
            width: 100%;
            border-collapse: collapse;
        }
          th {
            background-color: #f2f2f2;
        
            }
            td{
            text-align: center;
                color: olive;
            
            }
            input{
          font-size: 15px;
          font-style: italic;
            
            }
 </style>
</head>
<body>
<%-- 	<%@ include file="Header.jsp"%> --%>
	<sf:form method="post" modelAttribute="form">

	<sf:hidden path="pageSize" />
		<sf:hidden path="pageNo" />
			<div style="height: 15px; margin-bottom: 12px">
				<H3 align="center" class="success" style="color: green">
					<c:if test="${not empty success}">${success}</c:if>
				</H3>
				<H3 align="center" class="error" style="color: red">
					<c:if test="${not empty error}">${error}</c:if>
				</H3>
			</div>
		<table>
			<tr>
				<td><sf:input path="firstName"  placeholder="Search Name" /></td>
				<td><sf:select path="id">
						<sf:option value="0">-----------select------------</sf:option>
						<sf:options items="${userList}" itemValue="id"
							itemLabel="firstName" />
					</sf:select></td>
				<td><input type="submit" name="operation" value="search"  style="color: green;"> 
				</td>
			</tr>
		</table>
		<table border="1">
			<tr>
				<th>Select</th>
				<th>ID</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Login</th>
				<th>Password</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td><sf:checkbox path="ids" value="${user.id}" /></td>
					<td><c:out value="${user.id }"></c:out></td>
					<td><c:out value="${user.firstName }"></c:out></td>
					<td><c:out value="${user.lastName }"></c:out></td>
					<td><c:out value="${user.login }"></c:out></td>
					<td><c:out value="${user.password }"></c:out></td>
					<td><c:out value="${user.dob }"></c:out></td>
					<td><c:out value="${user.address }"></c:out></td>
					<td><a href="<c:url value="/ctl/User?id=${user.id}" />">edit</a></td>
				</tr>
			</c:forEach>
			<c:forEach items="${nextlist}" var="nextuser">
			</c:forEach>
		</table>
		<table>
			<tr>
		
				<td><input type="submit" name="operation" value="previous" style="color: blue;"${form.pageNo == 1 ? 'disabled="disabled"' : ''} ></td>
				<td><input type="submit" name="operation" value="delete"  style="color: red;"></td>
				<td><input type="submit" name="operation" value="next"  style="color: green;"  value="next" ${list.size()<form.pageSize || nextlist.size()==0 ? 'disabled="disabled"' : ''}>
				</td>
			</tr>
		</table>
		
	</sf:form>
<%-- 	<%@ include file="Footer.jsp"%> --%>
</body>
</html>
