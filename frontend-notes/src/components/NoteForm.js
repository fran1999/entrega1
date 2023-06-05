import React, {useState } from 'react';

// Componente para agregar o editar una nota
function NoteForm({ onSubmit, onCancel, initialNote }) {
  const [note, setNote] = useState(initialNote || { title: '', content: '' });

  const handleInputChange = event => {
    const { name, value } = event.target;
    setNote(prevNote => ({ ...prevNote, [name]: value }));
  };

  const handleSubmit = event => {
    event.preventDefault();
    onSubmit(note);
  };

  const handleCancel = () => {
    onCancel();
  };

  return (
    <div>
      <div>Modal para ingresar los datos de la nota</div>
      <form onSubmit={handleSubmit}>
        <label>
          Título:
          <input
            type="text"
            name="title"
            value={note.title}
            onChange={handleInputChange}
          />
        </label>
        <br />
        <label>
          Contenido:
          <textarea
            name="content"
            value={note.content}
            onChange={handleInputChange}
          ></textarea>
        </label>
        <br />
        <button type="submit">Guardar</button>
        <button type="button" onClick={handleCancel}>Cancelar</button>
      </form>
    </div>
  );
}
export default NoteForm;