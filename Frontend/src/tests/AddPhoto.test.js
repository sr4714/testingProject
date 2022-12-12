import {render, screen} from '@testing-library/react'
import userEvent from '@testing-library/user-event'
import '@testing-library/jest-dom'
import AddPhoto from '../components/AddPhoto'
import { MemoryRouter } from 'react-router-dom';

test('loads and displays add photos page', async () => {
  // ARRANGE
  render(<AddPhoto />, {wrapper: MemoryRouter})

  // ACT
  await userEvent.click(screen.getByText('Back'))
  //await screen.getByText("Photo List");

  // ASSERT
  expect(screen.getByRole('heading')).toHaveTextContent('Add Photo')
  //expect(screen.getByRole('button')).toBeDisabled()
})