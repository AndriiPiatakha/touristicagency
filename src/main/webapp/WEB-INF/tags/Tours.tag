<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@ attribute name="tours" type="java.util.Collection" required="true"%>

<table>
<c:forEach items="${tours}" var="item">
	<tr>
		<td>
			${item.name}
		</td>
	</tr>
</c:forEach>
</table>

