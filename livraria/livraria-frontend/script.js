// script.js

document.getElementById('form-livro').addEventListener('submit', async function(event) {
    event.preventDefault();  // Previne o comportamento padrão do formulário

    const nome = document.getElementById('nome').value;
    const paginas = document.getElementById('paginas').value;
    const categoria = document.getElementById('categoria').value;

    // Verifique se todos os campos estão preenchidos
    if (!nome || !paginas || !categoria) {
        alert("Todos os campos são obrigatórios.");
        return;
    }

    try {
        // Envia a requisição POST para a API
        const response = await fetch('http://localhost:8080/livros', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ nome, paginas: parseInt(paginas), categoria })
        });

        // Verifica se a resposta foi bem-sucedida
        if (!response.ok) {
            throw new Error('Falha ao cadastrar livro');
        }

        // Caso a requisição tenha sido bem-sucedida, exibe uma mensagem
        const data = await response.json();
        alert('Livro cadastrado com sucesso!');
        adicionarLivroNaLista(data);  // Adiciona o livro à lista
        document.getElementById('form-livro').reset();  // Limpa o formulário
    } catch (error) {
        console.error('Erro:', error);
        alert('Erro ao cadastrar livro');
    }
});

// Função para adicionar o livro à lista no frontend
function adicionarLivroNaLista(livro) {
    const listaLivros = document.getElementById('lista-livros');
    const li = document.createElement('li');
    li.textContent = `${livro.nome} - ${livro.categoria} - ${livro.paginas} páginas`;
    listaLivros.appendChild(li);
}
