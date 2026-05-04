import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, StyleSheet, ActivityIndicator, TouchableOpacity, Alert } from 'react-native';
import { IntercambioService } from '../services/ApiService';

const ESTADOS = {
  PENDIENTE:  { color: '#f5a623', label: 'Pendiente' },
  ACEPTADO:   { color: '#4caf50', label: 'Aceptado' },
  RECHAZADO:  { color: '#e94560', label: 'Rechazado' },
  COMPLETADO: { color: '#2196f3', label: 'Completado' },
};

export default function IntercambioScreen({ token }) {
  const [intercambios, setIntercambios] = useState([]);
  const [loading, setLoading] = useState(true);

  async function cargar() {
    setLoading(true);
    try {
      const data = await IntercambioService.getAll();
      setIntercambios(Array.isArray(data) ? data : [data]);
    } catch (err) { Alert.alert('Error', err.message); }
    finally { setLoading(false); }
  }

  async function cambiarEstado(id, nuevoEstado) {
    try {
      await IntercambioService.actualizarEstado(id, { estado: nuevoEstado }, token);
      cargar();
    } catch (err) { Alert.alert('Error', err.message); }
  }

  useEffect(() => { cargar(); }, []);

  if (loading) return <ActivityIndicator style={styles.center} size="large" color="#e94560" />;

  return (
    <FlatList
      style={styles.lista}
      data={intercambios}
      keyExtractor={(item, i) => String(item.id_intercambio ?? i)}
      renderItem={({ item }) => {
        const est = ESTADOS[item.estado] ?? { color: '#aaa', label: item.estado ?? 'Sin estado' };
        return (
          <View style={styles.tarjeta}>
            <Text style={styles.id}>Intercambio #{item.id_intercambio ?? '?'}</Text>
            <Text style={[styles.estado, { color: est.color }]}>{est.label}</Text>
            {item.id_usuario_origen && (
              <Text style={styles.info}>De: {item.id_usuario_origen} a {item.id_usuario_destino}</Text>
            )}
            {item.estado === 'PENDIENTE' && (
              <View style={styles.acciones}>
                <TouchableOpacity style={[styles.btn, { backgroundColor: '#4caf50' }]}
                  onPress={() => cambiarEstado(item.id_intercambio, 'ACEPTADO')}>
                  <Text style={styles.btnTexto}>Aceptar</Text>
                </TouchableOpacity>
                <TouchableOpacity style={[styles.btn, { backgroundColor: '#e94560' }]}
                  onPress={() => cambiarEstado(item.id_intercambio, 'RECHAZADO')}>
                  <Text style={styles.btnTexto}>Rechazar</Text>
                </TouchableOpacity>
              </View>
            )}
          </View>
        );
      }}
    />
  );
}

const styles = StyleSheet.create({
  lista:    { backgroundColor: '#1a1a2e', flex: 1, padding: 12 },
  center:   { flex: 1, justifyContent: 'center' },
  tarjeta:  { backgroundColor: '#16213e', borderRadius: 10, padding: 16, marginBottom: 12 },
  id:       { color: '#fff', fontWeight: 'bold', fontSize: 15 },
  estado:   { marginTop: 4, fontWeight: '600' },
  info:     { color: '#aaa', marginTop: 4, fontSize: 12 },
  acciones: { flexDirection: 'row', marginTop: 12, gap: 10 },
  btn:      { flex: 1, borderRadius: 8, padding: 10, alignItems: 'center' },
  btnTexto: { color: '#fff', fontWeight: 'bold' },
});
