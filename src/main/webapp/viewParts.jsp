<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="View Parts" />
<c:if test="${user == null}" >
    <c:redirect url = "index.jsp"/>
</c:if>
<html lang="en">
    <%@include file="head.jsp"%>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="py-3">
                <h3 class="d-inline text-decoration-underline">View Parts</h3>
                <a class="btn btn-secondary float-end" href="savedParts.jsp">View Saved Parts</a>
            </div>

            <form class="row my-3" action="searchParts" method="get">
                <i class="bi bi-search col-auto fs-3"></i>
                <div class="col-auto">
                    <input type="text" class="form-control mb-3"
                           name="searchTerm" id="searchTerm" placeholder="Search for a part"/>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="searchBy" id="byPartName" checked>
                        <label class="form-check-label" for="byPartName">By Part Name</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="searchBy" id="byPartNumber" >
                        <label class="form-check-label" for="byPartNumber">By Part Number</label>
                    </div>
                </div>
                <div class="col-auto">
                    <select class="form-select" name="categoryId">
                        <option selected>All Categories</option>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.id}">${category.category}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-success">Search</button>
                </div>
            </form>
            <hr>
            <div class="d-flex flex-row flex-wrap justify-content-around">
                <c:forEach var="part" items="${parts}">
                    <div class="card mx-3 my-3 parts" id="${part.id}">
                        <img src="${part.partImageFileLocation}" class="card-img-top border-bottom" alt="${part.partName}">
                        <div class="card-body">
                            <h5 class="card-title">${part.partName}</h5>
                            <h6 class="card-subtitle mb-2">${part.getLowestPrice()}</h6>
                            <h6 class="card-subtitle mb-2 text-muted">Part #: ${part.partNumber}</h6>
                        </div>
                        <div class="card-footer">
                            <c:if test="${user.getParts().contains(part)}" >
                                <a href="savedParts?action=unsave&partId=${part.id}" class="btn btn-secondary mb-2 me-3">UnSave</a>
                            </c:if>
                            <c:if test="${!user.getParts().contains(part)}" >
                                <a href="savedParts?action=save&partId=${part.id}" class="btn btn-secondary mb-2 me-3">Save</a>
                            </c:if>
                            <a href="viewAllPrices?partId=${part.id}" class="btn btn-info mb-2">View All Prices</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <%@include file="footer.jsp"%>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
                integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
                integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
