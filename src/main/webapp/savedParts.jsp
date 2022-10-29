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
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
                integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
                integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
