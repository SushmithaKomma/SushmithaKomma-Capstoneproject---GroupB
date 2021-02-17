<!DOCTYPE html>
<html>
<meta name="viewport" content="wide-device-width, initial-scale=1">
<head>

    <asset:stylesheet src="w3.css"/>

    <sec:ifAllGranted roles="ROLE_USER">
        <div class="w3-center">
            <h1 class="w3-text-green">
                <g:link controller="home" action="index">Sustainable Procurement</g:link>
            </h1>

            <div class="w3-container w3-green w3-right-align">
                ${loginName}
                <sec:ifLoggedIn>
                    <g:link class="w3-button w3-pale-green w3-round" controller="Logout">Logout</g:link>
                </sec:ifLoggedIn>
            </div>
        </div>
    </sec:ifAllGranted>

    <sec:ifAllGranted roles="ROLE_ADMIN">
        <div class="w3-center">

            <h1 class="w3-text-blue">
                <g:link controller="home" action="index">Sustainable Procurement: Administrator</g:link>
            </h1>

            <div class="w3-container w3-blue w3-right-align">
                <sec:ifLoggedIn>
                    <g:link class="w3-button w3-pale-blue w3-round" controller="Logout">Log Out</g:link>
                </sec:ifLoggedIn>
            </div>
        </div>
    </sec:ifAllGranted>

    <br>

</head>

</html>
