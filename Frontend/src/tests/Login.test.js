import {render, screen} from '@testing-library/react'
import userEvent from '@testing-library/user-event'
import '@testing-library/jest-dom'
import { MemoryRouter } from 'react-router-dom';
import Login from '../components/Login';

test('loads and displays Login', async () => {
    const user = userEvent.setup();
  // ARRANGE
  render(<Login />, {wrapper: MemoryRouter})

  // ACT
  await user.click(screen.getByRole('heading', { name: "Please Log In" }))
  //await screen.getByText("Photo List");

  // ASSERT
  expect(screen.getByRole('submit')).toHaveTextContent('Submit');
  //expect(screen.getByRole('button')).toBeDisabled()
})