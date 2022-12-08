<header class="d-flex flex-row justify-content-between align-items-center my-3">
  <a href="index.jsp" class="text-dark"><img src="images/HondaLogo.jpg" alt="Honda Logo"></a>
  <h1>Honda Auto Parts</h1>
  <c:if test="${user != null}" >
    <p class="text-dark small d-inline"><u><a href="viewProfile.jsp" class="link-dark">Hello, ${user.firstName}</a></u></p>
  </c:if>
  <c:if test="${user == null}" >
    <a href="login" class="text-dark small">Sign In/Sign Up</a>
  </c:if>
</header>
<c:if test="${user != null}" >
  <div class="d-flex flex-row justify-content-end">
    <p class="fw-bold">${temperature}&#x2109;</p>
  </div>
  <nav class="nav nav-pills justify-content-between">
</c:if>
<c:if test="${user == null}" >
  <nav class="nav nav-pills justify-content-start">
</c:if>
  <a href="index.jsp" class="nav-link text-dark">Home</a>
  <a href="getAllPartsAndCategories" class="nav-link text-dark">View Parts</a>
  <c:if test="${user != null}" >
    <a href="viewProfile.jsp" class="nav-link text-dark">View Profile</a>
    <a href="savedParts.jsp" class="nav-link text-dark">Saved Parts</a>
    <a href="signOut.jsp" class="nav-link text-light bg-secondary">Sign Out</a>
  </c:if>

</nav>
<hr>
