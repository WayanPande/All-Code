const judul = document.getElementById('judul'); 
judul.style.color = 'blue';
judul.style.backgroundColor = 'grey';
judul.innerHTML = 'lojik aih';

const p = document.getElementsByTagName('p');
p[1].style.backgroundColor = 'red';

const pBaru = document.createElement('p');
const teksPBaru = document.createTextNode('Paragraf baru');

pBaru.appendChild(teksPBaru);

const sectionA = document.getElementById('a');
sectionA.appendChild(pBaru);

const liBaru = document.createElement('li');
const teksLi = document.createTextNode('Li Baru');

liBaru.appendChild(teksLi);

const ul = document.querySelector('section#b ul');
const liNext = ul.querySelector('li:nth-child(2)');

ul.insertBefore(liBaru,liNext);

const link = document.querySelector('section#a a');
sectionA.removeChild(link);


const sectionB = document.getElementById('b');
const p4 = sectionB.querySelector('p');

const h2Baru = document.createElement('h2');
const teksH2 = document.createTextNode('H2 Baru');
h2Baru.appendChild(teksH2);

sectionB.replaceChild(h2Baru, p4);
