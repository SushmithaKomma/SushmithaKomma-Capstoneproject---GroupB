<!DOCTYPE html>
<html>
<title>Sustainable Procurement: View Accounts</title>
<meta name="viewport" content="wide-device-width, initial-scale=1">
<asset:stylesheet src="w3.css"/>
<head>

    <g:render template="/common/header"/>

</head>

<body>

<div class="w3-center">
    <strong>Supplier Accounts</strong>
</div>

<br>

<g:form>
    <g:hiddenField name="oldUsername" value="${oldUsername}"/>
    <table class="w3-border w3-border-blue w3-striped" align="center">
        <g:if test="${oldUsername}">
            <tr>
                <td class="w3-blue w3-center">
                    Old Username:
                </td>
                <td>
                    ${oldUsername}
                </td>
            </tr>
        </g:if>
        <g:if test="${nameInUse}">
            <tr>
                <td class="w3-pale-red w3-center" colspan="4">
                    User name ${nameInUse} is already in use.
                </td>
            </tr>
        </g:if>
        <tr>
            <th class="w3-blue">
                New Username:
            </th>
            <td>
            <g:textField class="input" name="username" value="${oldUsername}" placeholder="User Name" required="true"/>
            </td>
        </tr>
        <g:if test="${invalidEmail}">
            <tr>
                <td class="w3-pale-red w3-center" colspan="4">
                    Address ${invalidEmail} is invalid.
                </td>
            </tr>
        </g:if>
        <tr>
            <th class="w3-blue">
                New Email Address:
            </th>
            <td><g:textField class="input" name="email" value="${oldEmail}" placeholder="Email" required="true"/></td>
        </tr>
        <g:if test="${!oldUsername}">
            <tr>
                <th class="w3-blue">
                    New Password:
                </th>
                <td><g:passwordField name="password" placeholder="Password" required="true"/></td>
            </tr>
        </g:if>
        <tr>
            <th class="w3-blue">
                Administrator Account?
            </th>
            <td>
            <g:if test="${!oldUsername}">
                <g:checkBox name="admin" value="${false}"/>
            </g:if>
            <g:else>
                ${(isAdmin ? 'yes' : 'no')}
            </g:else>
            </td>
        </tr>
        <tr>
            <th class="w3-blue">
                Controller Account?
            </th>
            <td>
                <g:if test="${!oldUsername}">
                    <g:checkBox name="controller" value="${false}"/>
                </g:if>
                <g:else>
                    ${(isController ? 'yes' : 'no')}
                </g:else>
            </td>
        </tr>
        <tr>
            <th class="w3-blue">Study Group</th>
        <td>
            <g:select name="studyGroup" from="${studyGroups}" value="${studyGroup}"/>
        </td>
        </tr>

    </table>
    <br>
    <div class="w3-center">
        <g:actionSubmit action="submitAccount" class="w3-button w3-border w3-pale-blue w3-round"
                        value="${(oldUsername ? 'Modify' : 'Add')} Account"/>
        <g:if test="${oldUsername}">
            <g:actionSubmit action="deleteAccount" class="w3-button w3-border w3-pale-blue w3-round"
                            value="Delete Account"/>
        </g:if>
        <g:link action="cancelAccountChange" params="${[newAccount:!oldUsername]}"
                class="w3-button w3-border w3-pale-red w3-round">Cancel</g:link>
    </div>
</g:form>

<br><br><br>


</body>

<footer>
    <g:render template="/common/footer"/>
</footer>

</html>
