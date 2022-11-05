<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Saved Parts" />
<c:if test="${user == null}" >
    <c:redirect url = "index.jsp"/>
</c:if>
<html lang="en">
<%@include file="head.jsp"%>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <h3 class="text-decoration-underline text-center pb-3">Your Saved Parts</h3>
            <c:if test="${user.getParts().size() == 0}" >
                <p class="text-center mt-5">You don't have any saved parts. Go save some!</p>
            </c:if>
            <c:if test="${user.getParts().size() != 0}" >
                <table class="table table-sm border mt-5">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Part Name</th>
                        <th>Part Number</th>
                        <th>Price</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="part" items="${user.parts}">
                        <tr>
                            <td class="w-25 h-25"><img class="img-thumbnail w-50" src="${part.partImageFileLocation}" alt="${part.partName}"></td>
                            <td class="align-middle">${part.partName}</td>
                            <td class="align-middle">${part.partNumber}</td>
                            <td class="align-middle">${part.getPartsMerchants().get(0).getPrice()}</td>
                            <td class="align-middle"><a class="text-dark" href="viewAllPrices?partId=${part.id}">View All Prices</a></td>
                            <td class="align-middle"><a class="btn btn-secondary" href="savedParts?action=remove&partId=${part.id}">Remove</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <%@include file="footer.jsp"%>
        </div>
        <%@include file="bootstrapFiles.jsp"%>
    </body>
</html>
