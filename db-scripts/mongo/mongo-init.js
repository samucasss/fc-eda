// Acessa o banco de dados padrão ou cria um novo
db = db.getSiblingDB('fc-eda-balances'); // Altere para o nome do seu banco de dados se necessário

db.createCollection('balances');

// Insere dois documentos na coleção 'balances'
db.balances.insertMany([
    { accountId: "12345", balance: 1000.50 },
    { accountId: "67890", balance: 2500.75 }
]);