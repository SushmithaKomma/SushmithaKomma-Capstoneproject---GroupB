<!DOCTYPE html>
<html>
<title>Sustainable Procurement: View Account</title>
<meta name="viewport" content="wide-device-width, initial-scale=1">
<asset:stylesheet src="w3.css"/>
<head>

    <g:render template="/common/header"/>

</head>

<body>

<div class="w3-center">
    <strong>Supplier Account ${username}</strong>
</div>

<br>

<g:if test="${!username}">
    <div>
        (No match found)
    </div>
</g:if>
<g:else>
    <table class="w3-border w3-border-blue w3-striped" align="center">
        <tr>
            <th class="w3-blue">User Name</th>
            <th class="w3-blue">Account</th>
        </tr>
        <tr class="w3-center">
            <td>
                ${username}
            </td>
            <td>
                <g:link class="w3-button w3-border w3-pale-blue w3-round" action="editAccount"
                        params="[oldUsername: username]">Modify</g:link>
            </td>
        </tr>
    </table>
</g:else>

<br>

<div class="w3-center">
    <g:link class="w3-button w3-border w3-pale-blue w3-round" action="viewAllAccounts" params="[allAccountDetails: 'false']">
        View Accounts
    </g:link>

    <g:link class="w3-button w3-border w3-pale-blue w3-round" controller="Home" action="index">
        Home
    </g:link>
</div>

<br><br><br>


</body>

<footer>
    <g:render template="/common/footer"/>
</footer>

</html>
