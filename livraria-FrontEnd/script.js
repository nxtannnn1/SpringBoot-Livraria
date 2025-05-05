document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('form-livro');
    const livrosLista = document.getElementById('livros-lista');
    let livroEditando = null; // Variável para armazenar o livro que está sendo editado

    // Função para atualizar a lista de livros
    function atualizarLivros() {
        fetch('http://localhost:8080/livros')  // Altere para a URL correta da sua API
            .then(response => response.json())
            .then(livros => {
                livrosLista.innerHTML = '';  // Limpa a lista antes de adicionar os novos livros
                livros.forEach(livro => {
                    const li = document.createElement('li');
                    li.textContent = `${livro.titulo} - ${livro.categoria} - ${livro.paginas} páginas`;

                    // Botão para excluir
                    const botaoExcluir = document.createElement('button');
                    botaoExcluir.textContent = 'Excluir';
                    botaoExcluir.addEventListener('click', () => excluirLivro(livro.id));

                    // Botão para editar
                    const botaoEditar = document.createElement('button');
                    botaoEditar.textContent = 'Editar';
                    botaoEditar.addEventListener('click', () => editarLivro(livro));

                    li.appendChild(botaoEditar);
                    li.appendChild(botaoExcluir);

                    livrosLista.appendChild(li);
                });
            })
            .catch(error => {
                console.error('Erro ao carregar livros:', error);
            });
    }

    // Função para excluir um livro
    function excluirLivro(id) {
        fetch(`http://localhost:8080/livros/${id}`, {  // Altere para a URL correta da sua API
            method: 'DELETE',
        })
        .then(response => {
            if (response.ok) {
                // Atualiza a lista de livros após a exclusão
                atualizarLivros();
            } else {
                alert('Erro ao excluir livro');
            }
        })
        .catch(error => {
            console.error('Erro ao excluir livro:', error);
        });
    }

    // Função para editar um livro
    function editarLivro(livro) {
        livroEditando = livro;
        document.getElementById('titulo').value = livro.titulo;
        document.getElementById('paginas').value = livro.paginas;
        document.getElementById('categoria').value = livro.categoria;
        form.querySelector('button').textContent = 'Atualizar';  // Muda o texto do botão para "Atualizar"
    }

    // Função para enviar os dados do formulário (cadastro ou atualização)
    form.addEventListener('submit', (event) => {
        event.preventDefault();  // Evita o envio padrão do formulário

        const titulo = document.getElementById('titulo').value;
        const paginas = document.getElementById('paginas').value;
        const categoria = document.getElementById('categoria').value;

        const livro = {
            titulo: titulo,
            paginas: paginas,
            categoria: categoria
        };

        if (livroEditando) {
            // Se estamos editando, enviamos um PUT para atualizar
            fetch(`http://localhost:8080/livros/${livroEditando.id}`, {  // Altere a URL para a da sua API
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(livro)
            })
            .then(response => {
                if (response.ok) {
                    // Após atualizar, limpa o formulário e recarrega a lista
                    livroEditando = null;
                    form.reset();
                    form.querySelector('button').textContent = 'Cadastrar';  // Restaura o texto do botão
                    atualizarLivros();
                } else {
                    alert('Erro ao atualizar livro');
                }
            })
            .catch(error => {
                console.error('Erro ao atualizar livro:', error);
            });
        } else {
            // Caso contrário, faz o cadastro
            fetch('http://localhost:8080/livros', {  // Altere a URL para a da sua API
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(livro)
            })
            .then(response => {
                if (response.ok) {
                    // Após cadastrar, recarrega a lista
                    atualizarLivros();
                    form.reset();
                } else {
                    alert('Erro ao cadastrar livro');
                }
            })
            .catch(error => {
                console.error('Erro ao cadastrar livro:', error);
            });
        }
    });

    // Chama a função para carregar os livros quando a página for carregada
    atualizarLivros();
});
