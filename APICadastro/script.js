const formulario = document.querySelector("form");

const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Itelefone = document.querySelector(".telefone");

function cadastrar() {

    //Será responsavel por acessar a API
    fetch("http://localhost:8080/usuarios",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },

            //Formato JSON do Objeto Cadastrar
            method: "POST",
            body: JSON.stringify({
                nome: Inome.value,
                email: Iemail.value,
                senha: Isenha.value,
                telefone: Itelefone.value

                //console.log(dados)

            })
        })
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })

};

function limparCache() {
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Itelefone.value = "";
};

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    //Chamando a função 
    cadastrar();
    limparCache();

});