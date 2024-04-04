let myName = prompt("Adınız nedir?", "Lütfen isminizi giriniz.");

let myNameDOM = document.querySelector('#myName');

myNameDOM.innerHTML = myName;

let myClockDOM = document.querySelector('#myClock');

let now = new Date();

let hours = now.getHours();
let minutes = now.getMinutes();
let seconds = now.getSeconds();

if(minutes < 10){
    minutes = minutes.toString().padStart(2, '0');
}
if(seconds < 10){
    seconds = seconds.toString().padStart(2, '0');
}

let days = ['Pazar', 'Pazartesi', 'Salı', 'Çarşamba', 'Perşembe', 'Cuma', 'Cumartesi'];
let today = days[now.getDay()];


myClockDOM.innerHTML = `${hours}: ${minutes}:${seconds} ${today}`;