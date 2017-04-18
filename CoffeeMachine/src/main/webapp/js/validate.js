function validSignIn(form)
        {
            var regularName=/^[a-zA-Z'][a-zA-Z-' ]+[a-zA-Z']?$/;
            var regularPassword=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$/;


            var name=form.name.value;
            var password=form.password.value;
            if(!regularName.test(name)){
                document.getElementById('errorName').innerHTML = "Incorrect name";


            }
            else if(!regularPassword.test(password))
            {
                document.getElementById('errorPassword').innerHTML = "Incorrect password";
            }
            else
            {
                var xhr = new XMLHttpRequest();
                var body ='command=login'+'&'+'name=' + encodeURIComponent(name) +
                    '&password=' + encodeURIComponent(password);
                xhr.open("POST", '/controller', true)
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
                xhr.send(body);
            }
        }

function validSignUp(form)
{
    var regularName=/^[a-zA-Z'][a-zA-Z-' ]+[a-zA-Z']?$/;
    var regularPassword=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$/;
    var regularEmail=/^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;


    var name=form.name.value;
    var password=form.password.value;
    var rePassword=form.rePassword.value;
    var email=form.email.value;

    var error;
    if(!regularName.test(name)){
        document.getElementById('errorName').innerHTML = "Incorrect name";

    }
    else if(!regularEmail.test(email))
    {
        document.getElementById('errorEmail').innerHTML = "Incorrect email";
        document.getElementById('errorName').innerHTML = " ";
    }
    else if(!regularPassword.test(password))
    {
        document.getElementById('errorPassword').innerHTML = "Incorrect password";
        document.getElementById('errorEmail').innerHTML = " ";
    }
    else if(password!=rePassword)
    {
        document.getElementById('errorRePassword').innerHTML = "passwords don't match";
        document.getElementById('errorPassword').innerHTML = " ";
    }
    else{
        var xhr = new XMLHttpRequest();
        var body ='command=registration'+'&'+'name=' + encodeURIComponent(name) +'&email'+email+
            '&password=' + encodeURIComponent(password);
        xhr.open("POST", '/controller', true)
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
        xhr.send(body);
    }

}