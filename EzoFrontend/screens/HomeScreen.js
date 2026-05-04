import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet, ScrollView } from 'react-native';

export default function HomeScreen({ navigation, usuario }) {
  const opciones = [
    { label: 'Ver Articulos', screen: 'Articulos' },
    { label: 'Mis Intercambios', screen: 'Intercambio' },
  ];
  return (
    <ScrollView style={styles.container} contentContainerStyle={styles.content}>
      <Text style={styles.bienvenida}>Hola, {usuario?.nombre_usuario ?? usuario?.email ?? 'Jugador'}</Text>
      {opciones.map((op) => (
        <TouchableOpacity key={op.screen} style={styles.tarjeta} onPress={() => navigation.navigate(op.screen)}>
          <Text style={styles.tarjetaTexto}>{op.label}</Text>
        </TouchableOpacity>
      ))}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container:    { flex: 1, backgroundColor: '#1a1a2e' },
  content:      { padding: 20 },
  bienvenida:   { fontSize: 22, color: '#fff', fontWeight: 'bold', marginBottom: 24 },
  tarjeta:      { backgroundColor: '#16213e', borderRadius: 12, padding: 20, marginBottom: 16, borderLeftWidth: 4, borderLeftColor: '#e94560' },
  tarjetaTexto: { color: '#fff', fontSize: 17, fontWeight: '600' },
});
