<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="View Prices" />
<html lang="en">
    <%@include file="head.jsp"%>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>

            <h3 class="text-decoration-underline text-center">${partToView.partName}</h3>
            <div class="row mt-5">
                <div class="col-12 col-lg-5">
                    <img class="w-50" src="${partToView.partImageFileLocation}" alt="${partToView.partName}">
                    <p class="pt-3">Part Number: ${partToView.partNumber}</p>
                    <p class="py-3">Part Name: ${partToView.partName}</p>
                    <p>Description:</p>
                    <p>${partToView.partDescription}</p>
                </div>
                <div class="col-12 col-lg-7">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Merchant</th>
                            <th>Merchant Site</th>
                            <th>Price</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="merchant" items="${partToView.partsMerchants}">
                            <tr>
                                <td class="w-25"><img class="img-thumbnail" src="${merchant.getMerchant().getLogoImageFileLocation()}" alt="${merchant.getMerchant().getName()} Logo"></td>
                                <td class="align-middle">${merchant.getMerchant().getName()}</td>
                                <td class="align-middle">${merchant.getMerchant().getWebsite()}</td>
                                <td class="align-middle">${merchant.getPrice()}</td>
                                <td class="align-middle"><a class="btn btn-success" href="${merchant.getLinkToPart()}" target="_blank" rel="noopener noreferrer">Buy</a></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>

            <%@include file="footer.jsp"%>
        </div>
        <%@include file="bootstrapFiles.jsp"%>
    </body>
</html>
