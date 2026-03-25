import { useEffect, useState } from "react";
import api from "../services/api";

function ConteudosAdmin() {
  const [conteudos, setConteudos] = useState([]);
  const [categorias, setCategorias] = useState([]);
  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");
  const [linkArquivo, setLinkArquivo] = useState("");
  const [tipoConteudo, setTipoConteudo] = useState("PDF");
  const [categoriaId, setCategoriaId] = useState("");

  const token = localStorage.getItem("token");

  async function carregarConteudos() {
    const response = await api.get("/conteudos");
    setConteudos(response.data);
  }

  async function carregarCategorias() {
    const response = await api.get("/categorias");
    setCategorias(response.data);
  }

  async function criarConteudo(e) {
    e.preventDefault();

    await api.post(
      "/conteudos",
      {
        titulo,
        descricao,
        linkArquivo,
        tipoConteudo,
        categoria: {
          id: Number(categoriaId),
        },
      },
      {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      }
    );

    setTitulo("");
    setDescricao("");
    setLinkArquivo("");
    setTipoConteudo("PDF");
    setCategoriaId("");
    carregarConteudos();
  }

  async function deletarConteudo(id) {
    await api.delete(`/conteudos/${id}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    carregarConteudos();
  }

  useEffect(() => {
    carregarConteudos();
    carregarCategorias();
  }, []);

  return (
    <div>
      <h1>Conteúdos</h1>

      <form onSubmit={criarConteudo}>
        <input
          type="text"
          placeholder="Título"
          value={titulo}
          onChange={(e) => setTitulo(e.target.value)}
        />

        <input
          type="text"
          placeholder="Descrição"
          value={descricao}
          onChange={(e) => setDescricao(e.target.value)}
        />

        <input
          type="text"
          placeholder="Link do arquivo"
          value={linkArquivo}
          onChange={(e) => setLinkArquivo(e.target.value)}
        />

        <select
          value={tipoConteudo}
          onChange={(e) => setTipoConteudo(e.target.value)}
        >
          <option value="PDF">PDF</option>
          <option value="VIDEO">VIDEO</option>
          <option value="LINK">LINK</option>
          <option value="JOGO">JOGO</option>
        </select>

        <select
          value={categoriaId}
          onChange={(e) => setCategoriaId(e.target.value)}
        >
          <option value="">Selecione uma categoria</option>
          {categorias.map((categoria) => (
            <option key={categoria.id} value={categoria.id}>
              {categoria.nome}
            </option>
          ))}
        </select>

        <button type="submit">Criar</button>
      </form>

      <ul>
        {conteudos.map((conteudo) => (
          <li key={conteudo.id}>
            {conteudo.titulo} - {conteudo.tipoConteudo}
            <button onClick={() => deletarConteudo(conteudo.id)}>Excluir</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ConteudosAdmin;