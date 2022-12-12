import {render, screen} from '@testing-library/react'
import userEvent from '@testing-library/user-event'
import '@testing-library/jest-dom'
import Dashboard from '../components/Dashboard'
import { MemoryRouter } from 'react-router-dom';

test('loads and displays dashboard', async () => {
    const user = userEvent.setup();
  // ARRANGE
  render(<Dashboard />, {wrapper: MemoryRouter})

  // ACT
  await user.click(screen.getByRole('button', { name: "Add Photo" }))
  //await screen.getByText("Photo List");

  // ASSERT
  expect(screen.getByRole('heading')).toHaveTextContent('Photo List');
  //expect(screen.getByRole('button')).toBeDisabled()
})