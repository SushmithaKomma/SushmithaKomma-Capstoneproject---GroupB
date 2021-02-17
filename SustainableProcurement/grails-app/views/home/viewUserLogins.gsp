<!DOCTYPE html>
<html>
<title>Sustainable Procurement: User - View Logins</title>
<meta name="viewport" content="wide-device-width, initial-scale=1">
<asset:stylesheet src="w3.css"/>
<head>
    <g:render template="/common/header"/>
</head>

<body>

<div class="w3-center">

    <strong>User - View All Logins</strong>
    <sec:ifAllGranted roles="ROLE_ADMIN">
        for Supplier Account ${uName}
    </sec:ifAllGranted>

</div>

<br>

<g:form action="viewUserLogins">

<table class="w3-border w3-border-green w3-bordered w3-striped" align="center">
    <g:if test="${!userLoginsDataFromDB}">
        <tr>
            <td align="center">
                (None)
            </td>
        </tr>
    </g:if>
    <g:else>
        <tr>
            <th class="w3-blue">Login Date</th>
        </tr>
        <g:each in="${userLoginsDataFromDB}" var="dataPoint" status="i">
            <tr>
                <td>
                    <g:formatDate  date="${userLoginsDataFromDB[i]}"/>
                </td>
            </tr>
        </g:each>
    </g:else>
</table>

</g:form>
<sec:ifAllGranted roles="ROLE_ADMIN">
    <br>
    <div class="w3-center">
        <g:link class="w3-button w3-border w3-pale-blue w3-round" controller="Home" action="viewAllAccounts">
            Household Account List
        </g:link>
        <br>
        <g:link class="w3-button w3-border w3-pale-blue w3-round" controller="Home" action="index">
            Home
        </g:link>

    </div>
</sec:ifAllGranted>

<br><br><br>

</body>

<footer>
    <g:render template="/common/footer"/>
</footer>


</html>
