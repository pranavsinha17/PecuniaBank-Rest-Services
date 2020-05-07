import { TestBed } from '@angular/core/testing';

import { ShareBetweenComponentsService } from './share-between-components.service';

describe('ShareBetweenComponentsService', () => {
  let service: ShareBetweenComponentsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShareBetweenComponentsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
