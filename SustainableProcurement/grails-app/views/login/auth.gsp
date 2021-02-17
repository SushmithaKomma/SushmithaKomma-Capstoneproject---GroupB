<!DOCTYPE html>
<html>
<title>Sustainable Procurement: Home page</title>
<meta name="viewport" content="wide-device-width, initial-scale=1">
<asset:stylesheet src="w3.css"/>
<html>

<head>
    <asset:link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
    <div class="w3-text-green" align="center">
        <h1>%{--<asset:image src="favicon.ico" width="40"/>--}% Sustainable Procurement</h1>
    </div>

</head>

<body>
<div id="login">

        <div class="w3-container w3-green" align="center">
            <g:message code='Login'/>
            <br>
            <g:if test='${flash.message}'>
                <div class="login_message">${flash.message}</div>
            </g:if>
        </div>

        <br>

        <table class="w3-border w3-border-green w3-striped" align="center">
            <tr>
                <td>

                    <form action="${postUrl ?: '/login/authenticate'}" method="POST"
                          id="loginForm" class="cssform" autocomplete="off">
                        <table>
                            <tr>
                                <td>
                                    <label for="username"><g:message code='springSecurity.login.username.label'/>:</label>
                                </td>
                                <td>
                                    <input type="text" class="text_" name="${usernameParameter ?: 'username'}" id="username"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="password"><g:message code='springSecurity.login.password.label'/>:</label>
                                </td>
                                <td>
                                    <input type="password" class="text_" name="${passwordParameter ?: 'password'}" id="password"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <span id="remember_me_holder">
                                        <input type="checkbox" label="remember_me" class="chk" name="${rememberMeParameter ?: 'remember-me'}"
                                            id="remember_me" <g:if test='${hasCookie}'>checked="checked"</g:if>/>
                                        <g:message code='springSecurity.login.remember.me.label'/>%{--</label>--}%
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit" class="w3-button w3-border w3-pale-green w3-round"
                                        id="submit" value="${message(code: 'springSecurity.login.button')}"/>
                                </td>
                            </tr>
                        </table>
                    </form>

                    <div class="w3-center">
                        <g:link class="w3-button w3-border w3-pale-green w3-round"
                                controller='register' action='forgotPassword'>
                            <g:message code='Reset Password'/>
                        </g:link>
                    </div>

                </td>
            </tr>
        </table>

</div>

<br><br><br>

<script>
    (function () {
        document.forms['loginForm'].elements['${usernameParameter ?: 'username'}'].focus();
    })();
</script>

</body>

<footer>
    <g:render template="/common/footer"/>
</footer>

</html>
