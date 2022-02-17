import React from 'react';
import { CircularProgress, Box } from '@mui/material';

export default function MyProgress() {
  return (
    <Box
      sx={{ mt: 40, display: 'flex', width: '100%' }}
      alignItems="center"
      justifyContent="center"
    >
      <CircularProgress />
    </Box>
  );
}
