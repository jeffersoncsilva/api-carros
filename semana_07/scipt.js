
var resultadoSaida = document.getElementById("resultado");
var operation = null;
var inputValid = true;

function isNumber(e){
    var number = Number(e);
    if(!inputValid)
        return;
    if(resultadoSaida.innerText === '_')
        resultadoSaida.innerText = "";
    resultadoSaida.innerText += e;
}

function isOperation(op){
    if(operation == null){
        if(op === 'sum'){
            resultadoSaida.innerText += ' + ';    
            operation = '+'; 
        }else if(op === 'sub'){
            resultadoSaida.innerText += ' - ';     
            operation = '-';
        }else if(op === 'div'){
            resultadoSaida.innerText += ' / ';     
            operation ='/';
        }else if(op === 'mult'){
            resultadoSaida.innerText += ' * ';
            operation = '*';
        }else if(op === 'rest'){
            resultadoSaida.innerText += ' % ';     
            operation= '%';
        }
    }
}

function calculateOp(equals){
    var conta = resultadoSaida.innerText;
    inputValid = false;
    var numeros = conta.split(operation);
    if(numeros.length <= 1){
        return;
    }
    var num1 = parseInt(numeros[0], 10);
    var num2 = parseInt(numeros[1], 10);
    var result;
    switch(operation){
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case '*':
            result = num1*num2;
            break;
        case '/':
            result = num1 / num2;
            break;
        case '%':
            result = num1 % num2;
            break;
    }
    resultadoSaida.innerText = result;

}

function clearAll(){
    resultadoSaida.innerText = "_";
    operation = null;
    inputValid = true;
}