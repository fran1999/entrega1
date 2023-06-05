import React, { useEffect, useState } from 'react';
import NoteForm from './NoteForm';
import axios from 'axios';

// Componente principal
function ListNotes() {
  const [notes, setNotes] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [editNoteId, setEditNoteId] = useState(null);
  const [showArchived, setShowArchived] = useState(false);

  useEffect(() => {
    fetchNotes();
  }, []);

  const fetchNotes = () => {
    axios
      .get('http://localhost:8081/api/v1/notes')
      .then(response => setNotes(response.data))
      .catch(error => console.log('Error al obtener las notas:', error));
  };

  const handleAddNote = () => {
    setEditNoteId(null);
    setShowModal(true);
  };

  const handleEditNote = note => {
    setEditNoteId(note.id);
    setShowModal(true);
  };

  const handleDeleteNote = noteId => {
    axios
      .delete(`http://localhost:8081/api/v1/notes/${noteId}`)
      .then(() => {
        setNotes(prevNotes => prevNotes.filter(note => note.id !== noteId));
      })
      .catch(error => console.log('Error al eliminar la nota:', error));
  };

  const handleArchiveNote = note => {
    axios
      .put(`http://localhost:8081/api/v1/notes/${note.id}`, {
        ...note,
        archive: !note.archive
      })
      .then(response => {
        updateNoteInList(response.data);
      })
      .catch(error => console.log('Error al desarchivar la nota:', error));
  };

  const handleFilterArchived = () => {
    setShowArchived(!showArchived);
  };

  const updateNoteInList = updatedNote => {
    setNotes(prevNotes =>
      prevNotes.map(note => (note.id === updatedNote.id ? updatedNote : note))
    );
  };

  const handleSubmitNote = note => {
    if (editNoteId) {
      axios
        .put(`http://localhost:8081/api/v1/notes/${editNoteId}`, note)
        .then(response => {
          updateNoteInList(response.data);
          setShowModal(false);
        })
        .catch(error => console.log('Error al editar la nota:', error));
    } else {
      axios
        .post('http://localhost:8081/api/v1/notes', note)
        .then(response => {
          setNotes(prevNotes => [...prevNotes, response.data]);
          setShowModal(false);
        })
        .catch(error => console.log('Error al crear la nota:', error));
    }
  };

  const handleCancelNote = () => {
    setShowModal(false);
  };

  const filteredNotes = showArchived
    ? notes.filter(note => note.archive)
    : notes.filter(note => !note.archive);

  return (
    <div>
      <h2>Listado de Notas</h2>
      <button onClick={handleAddNote}>Agregar Nota</button>
      <button onClick={handleFilterArchived}>
        {showArchived ? 'Mostrar No Archivadas' : 'Mostrar Archivadas'}
      </button>

      {showModal && (
        <NoteForm
          onSubmit={handleSubmitNote}
          onCancel={handleCancelNote}
          initialNote={editNoteId ? notes.find(note => note.id === editNoteId) : null}
        />
      )}

      <ul>
        {filteredNotes.map(note => (
          <li key={note.id}>
            <h3>{note.title}</h3>
            <p>{note.content}</p>
            {!note.archive && (
              <button onClick={() => handleArchiveNote(note)}>Archivar</button>
            )}
            {showArchived && (
              <button onClick={() => handleArchiveNote(note)}>Desarchivar</button>
            )}
            <button onClick={() => handleEditNote(note)}>Editar</button>
            <button onClick={() => handleDeleteNote(note.id)}>Eliminar</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListNotes;