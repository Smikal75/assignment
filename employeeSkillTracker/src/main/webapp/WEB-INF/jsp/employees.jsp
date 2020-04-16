<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<h2>Browse Employees</h2>
</div>

<div>
	<table >
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Company Email</th> 
			<th>Role</th>
			<th>Business Unit</th>
			<th>Assigned To</th> 
		</tr>
		<c:forEach var="employee" items="${employees}"> 
			<tr>
		
				<td><c:out value="${employee.name}"/></td> 
				<td><c:out value="${employee.game}"/></td>
				<td><c:out value="${employee.type}"/></td>
				<td><c:out value="${employee.location}"/></td>
				<c:url var="organizerDetail" value="/organizers/detail?=id"/>
				<td><c:out value="${employee.organizerId}"/></td>
				<td><c:out value="${employee.date}"/></td> 
			</tr>
		</c:forEach>
	</table>
</div>
