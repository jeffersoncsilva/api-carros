var bt0 = document.querySelector('.bt0');
var bt1 = document.querySelector('.bt1');
var bt2 = document.querySelector('.bt2');
var bt3 = document.querySelector('.bt3');
var bt4 = document.querySelector('.bt4');
var bt5 = document.querySelector('.bt5');
var bt6 = document.querySelector('.bt6');
var bt7 = document.querySelector('.bt7');
var bt8 = document.querySelector('.bt8');
var bt9 = document.querySelector('.bt9');

var btAdd = document.querySelector('.btAdd');
var btSub = document.querySelector('.btSub');
var btMul = document.querySelector('.btMul');
var btDiv = document.querySelector('.btDiv');

var btReset = document.querySelector('.btReset');
var btPercent = document.querySelector('.btPercentage');
var btResut = document.querySelector('.btResut');

var num1 = 0;
var num2 = 0;
var op = null;
var resultado = null;
var concluido = false;
var decimal = false;
var display = document.querySelector('.display');

btAdd.addEventListener('click', function(){
    decimal = false;
    op = "+";
    addDisplay("+");
});

btDiv.addEventListener('click', ()=>{
    decimal = false;
    op = "/";
    addDisplay("/");
});

btSub.addEventListener('click', ()=>{
    decimal = false;
    op="-";
    addDisplay("-");
});

btMul.addEventListener('click', ()=>{
    decimal = false;
    op="*";
    addDisplay("*");
});

btPercent.addEventListener('click', () =>{
    decimal = false;
    op="%";
    addDisplay("%");
});

bt1.addEventListener('click', function(){
    addCalc(1);
    addDisplay(1);
});
bt2.addEventListener('click', function(){
    addCalc(2);
    addDisplay(2);
});
bt3.addEventListener('click', function(){
    addCalc(3);
    addDisplay(3);
});
bt4.addEventListener('click', ()=>{addCalc(4); addDisplay(4);});
bt5.addEventListener('click', () => {addCalc(5); addDisplay(5);});
bt6.addEventListener('click', () => {addCalc(6); addDisplay(6);});
bt7.addEventListener('click', () => {addCalc(7); addDisplay(7);});
bt8.addEventListener('click', () => {addCalc(8); addDisplay(8);});
bt9.addEventListener('click', () => {addCalc(9); addDisplay(9);});
bt0.addEventListener('click', () => {addCalc(0); addDisplay(0);});

function addCalc(n){
    if(concluido){
        reset();
        concluido = false;
    }

    if(op == null){
        if(decimal){
            num1 += + n/10;
        }else{
            num1 = num1*10 + n;
        }
    }else{
        if(decimal){
            num2 += + n/10;
        }else{
            num2 = num2*10 + n;
        }
    }

    if(num1 == 0 || op == null || num2 == 0){
        btResut.disabled = true;
    }else{
        btResut.disabled = false;
    }
}


btResut.addEventListener('click', function(){
    concluido = true;
    switch (op){
        case "+" :
            soma();
            break;
        case "-":
            sub();
            break;
        case "*":
            multi();
            break;
        case "/":
            divi();
            break;
        case "%":
            percent();
            break;
    }
});

function multi(){
    setDisplay(num1*num2);
}

function divi(){
    setDisplay(num1/num2);
}

function sub(){
    setDisplay(num1 - num2);
}

function soma(){
    setDisplay(num1 + num2);
}

function percent(){
    setDisplay(num1 % num2);
}


function addDisplay(n){
    console.log(display.textContent.length);
    if(display.textContent.length < 12){
        display.textContent += n; 
    }
}

function setDisplay(str){
    display.textContent = str;
    if(display.textContent <= 12){
        display.textContent = display.textContent.trim();
    }else{
        display.textContent = display.textContent.substr(0, 11);
    }
}

btReset.addEventListener('click', reset);

function reset(){
    num1 = 0;
    num2 = 0;
    op = null;
    resultado = null;
    display.textContent = '';
    btResut.disabled = true;
    decimal = false;
}
