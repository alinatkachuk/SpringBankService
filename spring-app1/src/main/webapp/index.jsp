<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<body>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width-device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible " content="ie-edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
</head>
<div class="container">

    <section id="cover">
        <div id="cover-caption">
            <div class="container">
                <div class ="col-sm-10 col-sm-offset-1">
                    <h1>DELTA BANK WELCOMES YOU</h1>
                    <p>Ololololo</p>
                    <form action="" class="form-inline">
                        <button type="submit" class="btn btn-success btn-lg">Okay,go!</button>
                    </form>
                    <br>

                    <a href="#nav-main" class="btn btn-secondary-outline btn-sm" role="button">&darr;</a>

                </div>
            </div>
        </div>
    </section>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-full" id="nav-main">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">DELTA BANK</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

</body>
</html>
